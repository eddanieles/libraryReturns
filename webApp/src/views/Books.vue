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
          let userAmountRead = {read: 'Finished', partially: 'Partially', unread: 'Not Read'};
          let userTimeBorrowed = {less_week: 'Less then 1 week', twoTo3weeks: '2 to 3 weeks', morethen_4weeks: '4 weeks or more'};
          let userRating = {five: '★★★★★', four: '★★★★', three: '★★★', two: '★★', one: '★'};
          this.books = response.map(book => {
            
            if (book.amountRead) book.amountRead = userAmountRead[book.amountRead];
            if (book.rating) book.rating = userRating[book.rating];
            if (book.timeToRead) book.timeToRead = userTimeBorrowed[book.timeToRead];

            return book;

          })
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