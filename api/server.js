const express = require('express');
const path = require('path');
const { v4: uuidv4 } = require('uuid');
const randomId = require('random-id');
const app = express(),
    bodyParser = require("body-parser");
port = 3080;

// place holder for the data
const books = [{ "title": "Presumptions of Philosophy", "author": "Donald Daffy Duckworth", "numberOfPages": 657, "dewey": "120.563DUC", "amountRead": "read", "id": "995df073-43cf-4bc3-b064-d3a7683d3314" }, { "title": "Philosophical Ponderings", "author": "Mickey and Minnie Mouse", "numberOfPages": 1200, "dewey": "120.563DUC", "amountRead": "partially", "id": "59041658-8169-40c1-bdab-585c20e108f2" }, { "title": "Application of Natural Sciences", "author": "Rick Sanchez", "numberOfPages": 145, "dewey": "601.103SAN", "amountRead": "read", "id": "e99fdb95-5b46-48be-aa81-5d8671386af2" }, { "title": "Rented and Unread", "author": "Solitude O’Brien", "numberOfPages": 734, "dewey": "834.334OBR", "amountRead": "unread", "id": "f86445e5-72f5-4b55-9c09-a4f678d18a66" }];

app.use(bodyParser.json());
app.use(express.static(path.join(__dirname, '../webApp/dist')));

app.get('/api/books', (req, res) => {
    res.json(books);
});

app.post('/api/book', (req, res) => {
    const book = req.body;
    book.id = uuidv4();
    books.push(book);
    res.json("book returned");
});

app.get('/', (req, res) => {
    res.sendFile(path.join(__dirname, '../webApp/build/index.html'));
});

app.listen(port, () => {
    console.log(`Server listening on the port::${port}`);
});