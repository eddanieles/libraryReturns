<template>
  <div class="home">
    <form accept-charset="UTF-8" action="submit_action" autocomplete="off" method="GET"
    target="_blank"> 
        <fieldset>
            <legend>Book Return Form:</legend>
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
                        value="yes"
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
                        validation="optional|number|matches:/^[1-9]\d*$/"
                        :validation-messages="{matches: 'Must be a positive whole number.', number: 'Value must be a number.'}"
                    />
                    <FormulateInput
                        name="dewey"
                        label="Dewey Decimal Number:"
                        validation="optional|min:3,length|matches:/^[0-9]/"
                        :validation-messages="{matches: 'Value must start with number.', min: 'DDN must be at least 3 characters.'}"
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
                        name="Submit"
                    />
                    <div class="submitText">{{submissionText}}</div>
                </FormulateForm>
        </fieldset> 
    </form>
  </div>
</template>

<script>
import { createBook } from '../services/BookService'

export default {
    name: 'CreateBook',
    data() {
        return {
            formValues: {},
            submissionText: ""
        }
    },
    methods: {
        handleSubmit() {
            createBook(this.formValues);
            this.formValues = {
                "amountRead": "read", 
                "timeToRead": "less_week", 
                "rating": "five", 
                "title": ""
            };
            this.submissionText = "Please enter another book to return."
        }
    }
}
</script>

<style>
    .submitText {
        font: italic;
        font-size: smaller;
        margin: 0px;
    }
</style>