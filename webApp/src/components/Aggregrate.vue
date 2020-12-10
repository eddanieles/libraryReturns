<template>
    <div>
        <div>
            Total Pages Read: {{books.map((book) => {
                        if (book.amountRead === "unread") book.numberOfPages = 0;
                        else if (book.amountRead === "partially") book.numberOfPages = parseInt(book.numberOfPages)/2;
                        return book.numberOfPages
                    })
                    .reduce((accumulator, currentValue, currentIndex, array) => { 
                        return parseInt(accumulator) + parseInt(currentValue)
                    })
            }}
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
                cats: deweyCategories
            }
        },
        methods: 
        {
            initializeBooks() {
                getAllBooks().then(response => {
                    this.books = response;
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