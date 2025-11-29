import React, {Component} from "react";

class Menu extends Component {

  submitForm = () =>{
    this.props.handleSubmit (this.state)
    
  }
  render(){
    
    return (
      <div>
        <h1>Lista de Productos</h1>

        <div>
            <table>
                <tbody>
                    <tr>
                        <td>
                          <img src="https://www.pcfactory.com.pe/public/foto/3997/1_200.jpg?t=1758641420195" alt="Laptop Gamer Acer Nitro 16 FHD Intel Core i5-13420"></img>
                          <th>S/. 4400</th>
                          <input type="button" value="Comprar" onClick={this.submitForm}/>

                        </td>
                        <td>
                          <img src="https://www.pcfactory.com.pe/public/foto/3489/1_200.jpg?t=1758641422779" alt="Laptop Gamer Acer Nitro V 15.6 FHD 144Hz Intel Core i5-13420"></img>
                          <th>S/. 4000</th>
                          <input type="button" value="Comprar" onClick={this.submitForm}/>

                        </td>
                    </tr>
                    <tr>
                        <td>
                          <img src="https://www.pcfactory.com.pe/public/foto/3749/1_200.jpg?t=1758641425640" alt="Laptop Gamer Acer Nitro V 15.6 FHD 144Hz Intel Core i9-13900"></img>
                          <th>S/. 5700</th>
                          <input type="button" value="Comprar" onClick={this.submitForm}/>

                        </td>
                        <td>
                          <img src="https://www.pcfactory.com.pe/public/foto/3490/1_200.jpg?t=1758641428276" alt="Laptop Gamer Acer Nitro V 15.6 FHD 165Hz Intel Core i7-13620"></img>
                          <th>S/. 4900</th>
                          <input type="button" value="Comprar" onClick={this.submitForm}/>

                        </td>
                    </tr>
                </tbody>
            </table>
        </div>

      </div>
    )
  }
}


export default Menu;