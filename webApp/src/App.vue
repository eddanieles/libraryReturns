<template>
  <div id="app">
    <h1>Littlefoot Library</h1>
    <div id="nav">
      <router-link to="/">Home</router-link> |
      <router-link to="/returnBook">Make Return</router-link> |
      <router-link to="/books">Books</router-link>
    </div>
    <router-view/>
  </div>
</template>


<style>
  #app {
    font-family: Avenir, Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    color: #2c3e50;
  }
  #nav {
    text-align: center;
  }
</style>
