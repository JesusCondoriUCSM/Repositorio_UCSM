const express = require('express');
const appRouter = express.Router();

const con = require("../config/connection");



let sql_all = 'CALL usp_listar_books()';
let sql_insert = 'CALL usp_insertar_books(?,?,?)';

appRouter.get('/books',(req,res)=>{
    con.query(sql_all,(error,results)=>{
        if(error){
            throw error;
        }
        res.send(results);
    })
});

appRouter.post('/books',(req,res)=>{
    console.log("BODY RECIBIDO:", req.body);

    const book = {
        title : req.body.book_title,
        author : req.body.book_autor,
        publicado : req.body.book_published
    }

    con.query(sql_insert,[book.title,book.author,book.publicado]
        ,(error,results)=>{
            if(error){
                throw error;
            }
            res.send(results);
        }
    )
})

module.exports = appRouter;