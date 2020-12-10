<template>
    <div>
        <div>
            Total Pages Read: {{totalPagesRead}}
        </div>
        <div>Pages Read per Category: {{pagesReadByCatergory}}</div>
    </div>
</template>

<script>
    import { getAllBooks, deweyCategories } from '../services/BookService'
    import _ from 'underscore'

    export default {
        data() {
            return {
                books: [],
                cats: deweyCategories,
                totalPagesRead: 0,
                pagesReadByCatergory: {},
            }
        },
        methods: 
        {
            initializeBooks() {
                getAllBooks().then(response => {
                    this.books = response;
                    this.totalPagesRead = response.map((book) => {
                        if (book.amountRead === "unread") book.pagesRead = 0;
                        else if (book.amountRead === "partially") book.pagesRead = parseInt(book.numberOfPages)/2;
                        else if (book.amountRead === "read") book.pagesRead = parseInt(book.numberOfPages);

                        if (!book.dewey) book.category = "Category Not Provided"
                        else if (/^0/.test(book.dewey)) book.category = this.cats["000"];
                        else if (/^1/.test(book.dewey)) book.category = this.cats["100"];
                        else if (/^2/.test(book.dewey)) book.category = this.cats["200"];
                        else if (/^3/.test(book.dewey)) book.category = this.cats["300"];
                        else if (/^4/.test(book.dewey)) book.category = this.cats["400"];
                        else if (/^5/.test(book.dewey)) book.category = this.cats["500"];
                        else if (/^6/.test(book.dewey)) book.category = this.cats["600"];
                        else if (/^7/.test(book.dewey)) book.category = this.cats["700"];
                        else if (/^8/.test(book.dewey)) book.category = this.cats["800"];
                        else if (/^9/.test(book.dewey)) book.category = this.cats["900"];

                        return parseInt(book.pagesRead)
                    })
                    .reduce((accumulator, currentValue) => { 
                        return parseInt(accumulator) + parseInt(currentValue)
                    });

                    
                    this.pagesReadByCatergory = Object.entries(_.groupBy(response, 'category'))
                        .map(section => {  
                            return {name: section[0], total: section[1]}
                        })
                        .map(indy => {
                            if (indy.total.length > 1) {
                                indy.total = indy.total.reduce((a, b) => a.pagesRead + b.pagesRead)
                            } else if (indy.total.length === 1) {
                                indy.total = indy.total[0].pagesRead;
                            }
                            return indy;
                        });
    
                });
                
            }
        },
        mounted () {
            this.initializeBooks();

        }
    }
</script>

<style>

</style>