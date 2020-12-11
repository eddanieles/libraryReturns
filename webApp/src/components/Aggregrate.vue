<template>
    <div>
        <div>
            Total Pages Read: {{totalPagesRead}}
        </div><br>
        <div>Pages Read per Category:</div>
        <ul>
            <li v-for="index in pagesReadByCatergory" :key="index.category">
                {{index.name}} - {{index.total}}
            </li>
        </ul>
    </div>
</template>

<script>
    import { getAllBooks, findCategory, findPagesRead } from '../services/BookService'
    import _ from 'underscore'

    export default {
        data() {
            return {
                totalPagesRead: 0,
                pagesReadByCatergory: {},
            }
        },
        methods: 
        {
            initializeBooks() {
                getAllBooks().then(response => {
                    this.totalPagesRead = response.map((book) => {
                        findPagesRead(book);
                        findCategory(book);
                        return parseInt(book.pagesRead)
                    })
                    .reduce((a, b) => { 
                        return parseInt(a) + parseInt(b)
                    });

                    
                    this.pagesReadByCatergory = Object.entries(_.groupBy(response, 'category'))
                        .map(section => {  
                            return {name: section[0], total: section[1]}
                        })
                        .map(indy => {
                            if (indy.total.length > 1) {
                                indy.total = parseInt(indy.total.reduce((a, b) => a.pagesRead + b.pagesRead));
                            } else if (indy.total.length === 1) {
                                indy.total = parseInt(indy.total[0].pagesRead);
                            }
                            return indy;
                        })
                        .filter(indy => {
                            if (indy.total > 0) return indy;
                        });
    
                });
                
            }
        },
        mounted () {
            this.initializeBooks();

        }
    }
</script>

<style>

</style>