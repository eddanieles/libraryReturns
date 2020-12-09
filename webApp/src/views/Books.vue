<template>
  <div class="books">
    <h1>Returned Books</h1>
    <div>{{books}}</div>
  </div>
</template>

<script>
  import { getAllBooks } from '../services/BookService'
  export default {
    data() {
        return {
            books: []
        }
    },
    methods: 
    {
      getAllBooks() {
        getAllBooks().then(response => {
          console.log(response)
          this.books = response
        })
      }
    },
    mounted () {
      this.getAllBooks();
    }
  }
</script>
