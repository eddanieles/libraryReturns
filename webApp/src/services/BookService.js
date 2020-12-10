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

export const deweyCategories = {
    "000": "Computer Science, Information & General Works",
    "100": "Philosophy & Psychology",
    "200": "Religion",
    "300": "Social Sciences",
    "400": "Language",
    "500": "Pure Science",
    600: "Applied Science",
    700: "Arts & Recreation",
    800: "Literature",
    900: "History & Geography"
}