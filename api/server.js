const express = require('express');
const path = require('path');
const { v4: uuidv4 } = require('uuid');
const app = express(),
    bodyParser = require("body-parser");
port = 3080;

// place holder for the data
const books = [];

app.use(bodyParser.json());
app.use(express.static(path.join(__dirname, '../my-app/dist')));

app.get('/api/books', (req, res) => {
    res.json(books);
});

app.post('/api/book', (req, res) => {
    const book = req.body.book;
    book.id = uuidv4();
    books.push(book);
    res.json("book returned@");
});

app.get('/', (req, res) => {
    res.sendFile(path.join(__dirname, '../my-app/build/index.html'));
});

app.listen(port, () => {
    console.log(`Server listening on the port::${port}`);
});