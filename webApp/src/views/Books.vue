<template>
  <div class="books">
    <fieldset>      
      <legend>List for Returned Books:</legend>
      <div>
        <ul>
          <li class="bookInList" v-for="book in books" :key="book.id">
            <span class="bookFieldTitle">Title:</span> {{book.title}}<br>
            <span class="bookFieldTitle">Author:</span> {{book.author}}<br>
            <span class="bookFieldTitle">Pages:</span> {{book.numberOfPages}}<br>
            <span class="bookFieldTitle">Dewey Decimal Number:</span> {{book.dewey}}<br><br>

            <span class="bookFieldTitle">Rating:</span> {{book.rating}}<br>
            <span class="bookFieldTitle">Name:</span> {{book.name}}<br>
            <span class="bookFieldTitle">Town Resident:</span> {{book.townResident}}<br>
            <span class="bookFieldTitle">Amount Read:</span> {{book.amountRead}}<br>
            <span class="bookFieldTitle">Time Book Borrowed:</span> {{book.timeToRead}}
          </li>
        </ul>
      </div>
    </fieldset>
  </div>
</template>

<script>
  import { getAllBooks, getUItext } from '../services/BookService'
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
          this.books = response.map(book => getUItext(book))
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
  .bookInList {
    border: 1px solid black;
    margin: 10px;
    padding: 10px;
  }
  .bookFieldTitle {
    font-style: italic;
    font-size: small;
  }
</style>