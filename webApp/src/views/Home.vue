

<template>
  <div>
      <create-book @createBook="bookCreate($event)" />
  </div>
</template>

<script>
import { createBook } from '../services/BookService'
import CreateBook from '../components/CreateBook.vue'

export default {
  components: { CreateBook },
  data() {
    return {
          books: []
      }
  },
  methods: {
    bookCreate(data) {
        console.log('data:::', data)
        createBook(data).then(response => {
            console.log(response);
            this.getAllBooks();
        });
    }
  }
}
</script>

<style>

</style>