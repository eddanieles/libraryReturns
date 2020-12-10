<template>
    <div>
        <div>
            Total Pages Read: {{totalPagesRead}}
        </div>
        <div>{{cats["500"]}}</div>
    </div>
</template>

<script>
    import { getAllBooks, deweyCategories } from '../services/BookService'
    export default {
        data() {
            return {
                books: [],
                cats: deweyCategories,
                totalPagesRead: 0
            }
        },
        methods: 
        {
            initializeBooks() {
                getAllBooks().then(response => {
                    this.books = response;
                    this.totalPagesRead = response.map((book) => {
                        if (book.amountRead === "unread") book.numberOfPages = 0;
                        else if (book.amountRead === "partially") book.numberOfPages = parseInt(book.numberOfPages)/2;
                        return parseInt(book.numberOfPages)
                    })
                    .reduce((accumulator, currentValue) => { 
                        return parseInt(accumulator) + parseInt(currentValue)
                    });
                })
            }
        },
        mounted () {
            this.initializeBooks();

        }
    }
</script>

<style>

</style>