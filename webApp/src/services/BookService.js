export async function getAllBooks() {

    const response = await fetch('/api/books');
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