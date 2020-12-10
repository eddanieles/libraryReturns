

<template>
  <div>
      <aggregrate />
      <create-book />
  </div>
</template>

<script>
import Aggregrate from '../components/Aggregrate.vue'
import CreateBook from '../components/CreateBook.vue'

export default {
  components: { CreateBook, Aggregrate },
  // data() {
  //   return {
  //         books: []
  //     }
  // }
}
</script>

<style>

</style>