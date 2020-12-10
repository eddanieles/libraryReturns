<template>
  <div class="home">
    <h1>Littlefoot Library</h1>
<form accept-charset="UTF-8" action="submit_action" autocomplete="off" method="GET"
target="_blank"> <fieldset>
<legend>Book Return:</legend>
 <FormulateForm
        v-model="formValues" @submit="handleSubmit"
        >
        <FormulateInput
            name="name"
            label="Your Name:"
        />
        <FormulateInput
            type="radio"
            name="townResident"
            label="Town Resident?"
            :options="{yes: 'Yes', no: 'No'}"
        />
        <FormulateInput
            name="title"
            label="Title:"
            validation="required"
        />
        <FormulateInput
            name="author"
            label="Author:"
        />
        <FormulateInput
            name="numberOfPages"
            label="Number of Pages:"
        />
        <FormulateInput
            name="dewey"
            label="Dewey Decimal Number:"
        />
        <FormulateInput
            type="select"
            name="amountRead"
            label="How Much of the book was read?"
            :options="{read: 'Read', partially: 'Partially', unread: 'Not Read'}"
        />
        <FormulateInput
            type="select"
            name="timeToRead"
            label="Time taken to read book:"
            :options="{less_week: 'Less then 1 week', twoTo3weeks: '2 to 3 weeks', morethen_4weeks: '4 weeks or more'}"
        />
        <FormulateInput
            type="select"
            name="rating"
            label="Your rating:"
            :options="{five: '★★★★★', four: '★★★★', three: '★★★', two: '★★', one: '★'}"
        />
        <FormulateInput
            type="submit"
            label="Submit"
        />
    </FormulateForm>
</fieldset> </form>
  </div>
</template>

<script>
import { createBook } from '../services/BookService'

export default {
    name: 'CreateBook',
    data() {
        return {
            formValues: {}
        }
    },
    methods: {
        handleSubmit() {
            // const payload = this.formValues;
            // this.$emit('createUser', payload)
            // console.log(JSON.stringify(payload));
            createBook(this.formValues);
        }
    }
}
</script>

<style>
    .home {
        text-align: left;
    }
</style>