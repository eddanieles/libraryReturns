<template>
  <div class="books">
    <h1>Books</h1>
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
        console.log(response);
        this.books = response;
      })
    }
  },
  mounted () {
    this.getAllBooks();
  }
}
</script>
