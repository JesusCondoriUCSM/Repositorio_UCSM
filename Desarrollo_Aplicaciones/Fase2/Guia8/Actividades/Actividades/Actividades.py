"""Welcome to Reflex! This file outlines the steps to create a basic app."""

import reflex as rx

from rxconfig import config


class State(rx.State):
    """The app state."""
    mensaje:str = ""

    def boton_presionado(self):
        self.mensaje="Botón presionado!"
        print(self.mensaje)
        


def index() -> rx.Component:
    # Welcome Page (Index)
    return rx.hstack(
        rx.button("Botón 1", color_scheme="blue", on_click=State.boton_presionado),
        rx.button("Botón 2",bg="black"),
        rx.button("Botón 3")
    )

app = rx.App()
app.add_page(index)
