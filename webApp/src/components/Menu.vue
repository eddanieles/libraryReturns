<template>
    <div class="menu">
        <ul>
            <li>Home</li>
            <li>Books</li>
        </ul>
    </div>
</template>

<script>
export default {
    name: 'Menu'
}
</script>

<style scoped>
    div {
        text-align: center;
    }
    ul {
        display: flex;
        list-style-type: none;
    }

    li {
        flex-grow: inherit;
        flex: auto;
    }
</style>