const express = require('express');
const jwt = require('jsonwebtoken');
const app = express();

app.use(express.json());


app.get('/public', (req, res) => {
    res.json({ mensaje: "Esta es la Data de Clientes" });
});

// GENERA TOKEN
app.post('/login', (req, res) => {
    const user = {
        id: 101,
        username: "gustavo",
        role: "admin"
    };

    
    jwt.sign(
        { user },
        'secretkey',
        { expiresIn: '60s' },
        (err, token) => {
            res.json({ token });
        }
    );
});

// VERIFICAR TOKEN
function verifyToken(req, res, next) {
    const authHeader = req.headers["authorization"];

    if (!authHeader) return res.status(403).json({ error: "Token requerido" });

    const token = authHeader.split(" ")[1];

    jwt.verify(token, "secretkey", (err, decoded) => {
        if (err) {
            return res.status(403).json({ error: "Token inválido o expirado" });
        }

        req.userData = decoded; // guarda info del usuario
        next();
    });
}

// RUTA PROTEGIDA
app.get('/profile', verifyToken, (req, res) => {
    res.json({
        mensaje: "Perfil del usuario autenticado",
        user: req.userData.user
    });
});

// RUTA PROTEGIDA
app.get('/orders', verifyToken, (req, res) => {
    res.json({
        mensaje: "Listado de pedidos",
        pedidos: [1001, 1002, 1003],
        user: req.userData.user
    });
});

app.listen(5000, () => console.log("Servidor ejecutándose en el puerto 5000"));
