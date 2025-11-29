"""Welcome to Reflex! This file outlines the steps to create a basic app."""

import reflex as rx

from rxconfig import config


class States(rx.State):
    """The app state."""
    mensaje:str = ""

    def boton_presionado(self):
        self.mensaje="Botón presionado!"
        print(self.mensaje)
        
    
def mi_componente():

    return rx.vstack(
        rx.button("Botón 1", color_scheme="blue", on_click=States.boton_presionado),
        rx.button("Botón 2",bg="black"),
        rx.button("Botón 3"),

        rx.heading("Este es un encabezado H1", size="6"),
        rx.heading("Este es un encabezado H3", size="3")
    )
@rx.page(route="/")

def index() -> rx.Component:
    # Welcome Page (Index)
    return mi_componente()

app = rx.App()
app.add_page(index)
