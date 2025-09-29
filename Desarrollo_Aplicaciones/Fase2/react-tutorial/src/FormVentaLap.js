import React, {Component} from "react";

class FormR extends Component {
  initialState = {
      nombre: '',
      descripcion: '',
      precio: '',
  }
  state = this.initialState

  handleChange = (event) =>{
      const {name, value} = event.target

      this.setState({
          [name]: value,
      })
  }

  submitForm = () =>{
    this.props.handleSubmit (this.state)
    this.setState (this.initialState)
  }

  render(){
      const {nombre, descripcion, precio} = this.state;

      return(
          <form>
              <label htmlFor="nombre">Nombre</label>
              <input type="text" name="nombre" id="nombre" value={nombre} onChange={this.handleChange} />
              <label htmlFor="edad">Descripcion</label>
              <input
              type="text"
              name="descripcion"
              id="descripcion"
              value={descripcion}
              onChange={this.handleChange} />
              <label htmlFor="correo">Precio</label>
              <input
              type="text"
              name="precio"
              id="precio"
              value={precio}
              onChange={this.handleChange} />
              <input type="button" value="Submit" onClick={this.submitForm}/>
          </form>
      )
  }
}

export default FormR