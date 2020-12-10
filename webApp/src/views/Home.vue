

<template>
  <div>
      <create-book />
  </div>
</template>

<script>
import CreateBook from '../components/CreateBook.vue'

export default {
  components: { CreateBook },
  data() {
    return {
          books: []
      }
  }
}
</script>

<style>

</style>