export async function getAllBooks() {

    const response = await fetch('/api/books', {
        headers: {
            'Content-Type': 'application/json',
            'Accept': 'application/json'
        }
    });
    return await response.json();
}

export async function createBook(data) {
    const response = await fetch(`/api/book`, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(data)
    })
    return await response.json();
}

export function findCategory(book) {

    if (!book.dewey) book.category = "Category Not Provided"
    else if (/^0/.test(book.dewey)) book.category = "Computer Science, Information & General Works";
    else if (/^1/.test(book.dewey)) book.category = "Philosophy & Psychology";
    else if (/^2/.test(book.dewey)) book.category = "Religion";
    else if (/^3/.test(book.dewey)) book.category = "Social Sciences";
    else if (/^4/.test(book.dewey)) book.category = "Language";
    else if (/^5/.test(book.dewey)) book.category = "Pure Science";
    else if (/^6/.test(book.dewey)) book.category = "Applied Science";
    else if (/^7/.test(book.dewey)) book.category = "Arts & Recreation";
    else if (/^8/.test(book.dewey)) book.category = "Literature";
    else if (/^9/.test(book.dewey)) book.category = "History & Geography";

    return book;
}

export function findPagesRead(book) {
    if (book.amountRead === "unread") book.pagesRead = 0;
    else if (book.amountRead === "partially") book.pagesRead = parseInt(book.numberOfPages) / 2;
    else if (book.amountRead === "read") book.pagesRead = parseInt(book.numberOfPages);

    return book;
}