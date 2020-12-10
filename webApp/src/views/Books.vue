<template>
  <div class="books">
    <fieldset>      
      <legend>List for Returned Books:</legend>
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
      initializeBooks() {
        getAllBooks().then(response => {
          this.books = response
        })
      }
    },
    mounted () {
      this.initializeBooks();
    }
  }
</script>

<style>
  ul {
    list-style: none;
  }
  li {
    /* border: 1px solid black; */
    margin: 10px;
  }
</style>