<template>
  <div class="books">
    <h1>Books</h1>
    <button @click='getAllBooks()' type="button" class="btn btn-warning">Get all Books</button>
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
      // getAllBooks() {
      //   this.$emit('getAllBooks')
      // },
    },
    mounted () {
      this.getAllBooks();
    }
  }
</script>
