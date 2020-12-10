<template>
  <div class="books">
    <h1>Returned Books</h1>
    <fieldset>      
      <legend>Our Books:</legend>
      <div>
        <ul>
          <li v-for="book in books" :key="book.id">
            {{book}}
          </li>
        </ul>
      </div>
    </fieldset>
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
          this.books = response
        })
      }
    },
    mounted () {
      this.getAllBooks();
    }
  }
</script>
