<!-- app.vue -->
<template>
  <div id="app">
    <img alt="Vue logo" src="./assets/logo.png" />
    <HelloWorld msg="Hello Vue!" />
    <ol>
      <todo-item
        v-for="item in list"
        v-bind:todo="item"
        v-bind:key="item.id"
      ></todo-item>
    </ol>
  </div>
</template>

<script>
import HelloWorld from "./components/HelloWorld.vue";
import TodoItem from "./components/ToDoItem.vue";

export default {
  name: "App",
  data() {
    return {
      list: [
        {
          id: 0,
          text: "Prepare the environment",
        },
        {
          id: 1,
          text: "Writing the code",
        },
        {
          id: 2,
          text: "Build Service",
        },
      ],
    };
  },
  components: {
    HelloWorld,
    TodoItem,
  },
};
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #2c3e50;
  margin-top: 60px;
}
</style>

