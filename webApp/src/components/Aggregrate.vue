<template>
    <div>
        <div>
            Total Pages Read: {{totalPagesRead}}
        </div><br>
        <div>Pages Read per Category:</div>
        <ul>
            <li v-for="index in pagesReadByCatergory" :key="index.category">
                {{index.name}} - {{index.total}}
            </li>
        </ul>
    </div>
</template>

<script>
    import { getAllBooks, findCategory } from '../services/BookService'
    import _ from 'underscore'

    export default {
        data() {
            return {
                books: [],
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

                        findCategory(book);

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
                        })
                        .filter(indy => {
                            if (indy.total > 0) return indy;
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