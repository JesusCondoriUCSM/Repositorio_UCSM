import React, { Component } from "react";

class App extends Component {
  state = {
    data: null
  };

  componentDidMount() {
    const url = "https://pokeapi.co/api/v2/pokemon/ditto";

    fetch(url)
      .then((res) => res.json())
      .then((result) => {
        this.setState({
          data: result,
        });
      });
  }

  render() {
    const { data } = this.state;

    if (!data) {
      return <p>Cargando...</p>;
    }

    return (
      <div>
        <h1>{data.name.toUpperCase()}</h1>
        <p>ID: {data.id}</p>
        <p>Altura: {data.height}</p>
        <p>Peso: {data.weight}</p>

        <h3>Habilidades:</h3>
        <ul>
          {data.abilities.map((item, index) => (
            <li key={index}>{item.ability.name}</li>
          ))}
        </ul>
      </div>
    );
  }
}

export default App;
