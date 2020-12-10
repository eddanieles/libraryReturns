<template>
    <div>
        <div>
            {{books.map(book => book.numberOfPages)
                    .reduce((accumulator, currentValue, currentIndex, array) => { 
                        return parseInt(accumulator) + parseInt(currentValue)
                        })}}
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