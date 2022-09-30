<!-- app.vue -->
<template>
  <div id="app">
    <!-- <img alt="Vue logo" src="./assets/logo.png" /> -->
    <!-- <HelloWorld msg="Auto replay chat" /> -->
    <JwChat-index placeholder='Please input' :taleList="form.list" @enter="bindEnter" v-model="form.inputMsg"
      :showRightBox='true' scrollType="noscroll" :config="form.config" :toolConfig="form.toolConfig " />
    <!-- <ol>
      <todo-item
        v-for="item in list"
        v-bind:todo="item"
        v-bind:key="item.id"
      ></todo-item>
    </ol> -->
  </div>
</template>

<script>
// import HelloWorld from "./components/HelloWorld.vue";
// import TodoItem from "./components/ToDoItem.vue";

export default {
  name: "App",
  data() {
    return {
      form: {
        inputMsg: 'What is exposure?',
        list: [     
        {
        "date": (new Date()).toLocaleTimeString(),
        "text": { "text": 'This auto replay bot.' },
        "mine": false,
        "name": "AI Bot"
      }
           ],
        config: {
          img: '../image/cover.png',
          name: 'Finance auto replay chat',
          dept: 'Team CRD-T Victory',
          quickList: [{
            text: 'What is exposure?'
          },
          {
            text: 'What is today\'s dollar exchange rate with eur?'
          },
          {
            text: 'What is yesterday\'s dollar exchange rate with eur?'
          }]
        },
        answerMock: [
          
        {
          key: ['hi'],
          answer: 'Hi, what could i help you.'
        },
        
        {
          key: ['question'],
          answer: 'It\'s my pleasure, please.'
        },
        {
          key: ['exposure'],
          answer: 'Financial exposure is the amount an investor stands to lose in an investment should the investment fail.'
        },
        {
          key: ['exchange', 'dollar', 'today'],
          answer: 'It is 1.02 EUR to 1 USD'
        },
        {
          key: ['exchange', 'dollar', 'yesterday'],
          answer: 'It is 1.03 EUR to 1 USD.'
        }
        ],
        toolConfig: {
          active: 'win00',
          width: '160px',
          listHeight: '60px',
          list: [{
            id: 'win00',
            img: '/image/cover.png',
            name: 'Client A',
            dept: 'Guest'
          },
          {
            id: 'win01',
            img: '/image/three.jpeg',
            name: 'Client B',
            dept: 'Guest'
          },
          {
            id: 'win02',
            img: '/image/two.jpeg',
            name: 'Client C',
            dept: 'Guest'
          }]
        }
      },
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
  methods: {
    bindEnter() {
      console.log('bindEnter')
      const msg = this.form.inputMsg;
      if (msg == null || msg.length == 0)
        return;
      var obj = this.getChatMessage(false, msg);
      this.form.list.push(obj);
    },
    getChatMessage(isbot, msg) {
      var dat = (new Date()).toLocaleTimeString();
      const msgObj = {
        "date": dat,
        "text": { "text": msg },
        "mine": true,
        "name": "Client A"
      }
      return msgObj;
    }
  },
  components: {
    // HelloWorld,
    // TodoItem,
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

