"""Welcome to Reflex! This file outlines the steps to create a basic app."""

import reflex as rx

from rxconfig import config


class State(rx.State):
    """The app state."""
    mostrar_solo_pendientes: bool = False
    
    tareas: list[dict[str,str]] = [
        {"titulo": "Implementar UI", "estado": "Completado"},
        {"titulo": "Implementar login", "estado": "Pendiente"},
        {"titulo": "Implementar lógica de validación de usuario", "estado": "Pendiente"},
        {"titulo": "Implementar Base de Datos","estado":"Pendiente"},
    ]
    
    def mostrar_pendientes(self):
        self.mostrar_solo_pendientes = True
    
    def mostrar_todas(self):
        self.mostrar_solo_pendientes = False

def tarjeta_tarea(tarea):
    return rx.vstack(
        rx.text(tarea["titulo"]),
        margin="4px",
        color ="white"
        
        
    )

def columna_kanban(nombre, tareas):
    return rx.box(
        rx.heading(nombre, size="4"),
        rx.cond(
            State.mostrar_solo_pendientes,
            # Si está activado: mostrar solo pendientes
            rx.foreach(
                tareas,
                lambda t: rx.cond(
                    t["estado"] == "Pendiente",
                    tarjeta_tarea(t),
                    rx.fragment()
                )
            ),
            rx.foreach(tareas, tarjeta_tarea)
        )
    )

    

def index() -> rx.Component:
    # Welcome Page (Index)
    return rx.box(
        rx.center(
            rx.vstack(
                rx.hstack(
                    rx.text(
                        columna_kanban("Tareas",State.tareas),
                        color="lightblue",
                        align="center",
                        justify="center"
                    ),
                    border="4px solid white",
                    margin="10px",
                    padding="10px"
                ),
                
                rx.hstack(
                    rx.button("Mostrar solo Pendientes", on_click=State.mostrar_pendientes),
                    rx.button("Mostrar todas las tareas", on_click=State.mostrar_todas)
                ),
            ),
        ),
    )


app = rx.App()
app.add_page(index)
