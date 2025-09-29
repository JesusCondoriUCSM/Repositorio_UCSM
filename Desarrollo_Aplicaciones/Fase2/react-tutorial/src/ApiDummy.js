import React, { Component } from "react";

class App extends Component {
  state = {
    data: []
  };

  componentDidMount() {
    const url = "https://dummyjson.com/posts";

    fetch(url)
      .then((res) => res.json())
      .then((result) =>
        this.setState({
          data: result.posts, 
        })
      );
  }

  render() {
    const { data } = this.state;

    const result = data.map((entry) => {
      return <li key={entry.id}>{entry.title}</li>; 
    });

    return <ul>{result}</ul>;
  }
}

export default App;
