<!-- app.vue -->
<template>
  <div id="app">
    <!-- <img alt="Vue logo" src="./assets/logo.png" /> -->
    <!-- <HelloWorld msg="Auto replay chat" /> -->
    <JwChat-index placeholder='Please input' :taleList="form.list" @enter="bindEnter" v-model="form.inputMsg"
      :showRightBox='true' scrollType="noscroll" :config="form.config" :toolConfig="form.toolConfig " height="800"/>
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

import axios from 'axios';

export default {
  name: "App",
  data() {
    return {
      form: {
        inputMsg: 'hi',
        list: [
          {
            "date": (new Date()).toLocaleTimeString(),
            "text": { "text": 'This is auto replay bot.' },
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
      console.log(1)
      // get response
      var data = {
        "id": "document id",
        "content": msg,
        "extras": "",
        "resourceKey": "",
        "timestamp": 0,
        "title": "document title",
        "userId": "",
        "tags": []
      };
      console.log(data);
      axios({
        method: 'post',
        url: 'http://localhost:10001/hackathon/crdt/chat',
        data,
        // headers:{"Content-Type": 'application/x-www-form-urlencoded'}
      })
        .then(response => {
          var tags = response.data.tags;
          console.log(tags)
          var answer = this.getMatchAnswer(tags);
          this.form.list.push(this.getChatMessage(true, answer));
        })
        .catch(err => console.log(err));
    },
    getChatMessage(isbot, msg) {
      var dat = (new Date()).toLocaleTimeString();
      var name = "Client A"
      if (isbot)
        name = "AI Bot"
      const msgObj = {
        "date": dat,
        "text": { "text": msg },
        "mine": !isbot,
        "name": name
      }
      return msgObj;
    },
    getMatchAnswer(tags) { // based on tags to match answer
      for (var j = 0; j < this.form.answerMock.length; j++) {
        var flag = 0;
        var item = this.form.answerMock[j];
        for (var i = 0; i < item.key.length; i++) {
          if (tags.includes(item.key[i]))
            flag++;
        }
        if (flag == item.key.length)
          return item.answer;          
      }
      return "I could not catch what you want,Please give me sometime once i get the result will let you know.";
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

