import { useEffect, useState } from "react";

interface User {
    id: number;
    name: string;
    lastname: string;
    username: string;
    password: string;
}


export const Login = () => {
    const [userLogin, setUserLogin] = useState<User>();
    const [allUsers, setAllUsers] = useState([]);

    useEffect(() => {
        fetchUsers();
    }, []);

    const fetchUsers = () => {
        let headers = new Headers();
        //headers.set('Authorization', 'Basic' + btoa("test:test123"));
        fetch('http://localhost:8081/user/getUsers', {
            method: 'GET',
            //headers: headers,
        })
            .then(response => response.json())
            .then(data => setAllUsers(data))
            .catch(err => console.error("Erro en el fecht al encontrar datos " + err.message));
    };

    console.log(allUsers);

    const limpiarCadena = (user: string, pass: string) => {
        var userElement = document.getElementById(user);
        var passElement = document.getElementById(pass);
        if (!userElement || !passElement) {
            throw new Error("No existe el elemento con nombre " + userElement);
        }
        var str = userElement.value.replace(/[$&#'";]/g, "");
        var str3 = passElement.value.replace(/[$&#'";]/g, "");
        userElement = str;
        alert(userElement);
        consultarLogin(str, str3);
    }


    const consultarLogin = (user: string, pass: string) => {
        let headers = new Headers();
        headers.set('Content-Type', 'application/json');
        fetch("http://localhost:8081/user/getUser", {
            method: "POST",
            headers: headers,
            body: JSON.stringify({
                username: user,
                password: pass
            })
        })
            .then(response => {
                if (!response) {
                    throw new Error(`Http error! Status ${response.status}`);
                }
                return response.json();
            })
            .then(data => setUserLogin(data))
            .catch(err => console.error("Ocurrió un error: " + err.message));
    }

    const closeLogin = () => {
        alert("Cerrando sección de " + userLogin?.name + " " + userLogin?.lastname);
        setUserLogin(undefined);
    }


    return (
        <div className="">
            <h1>Inicio de Sesion</h1>

            <div id="container">
                <>
                    {
                        (userLogin ? (
                            <div>
                                <h2>GESTION DE USUARIOS</h2>
                                <h2>Logeado como: {userLogin.name} {userLogin.lastname}</h2>
                                <div id="container">
                                    <section id="content">
                                        <div>
                                            <button className="boton" onClick={() => closeLogin()}>Cerrar sesion</button>
                                        </div>
                                    </section>
                                </div>
                            </div>
                        ) : (
                            <div>
                                <section id="content">
                                    <form id="formulario_login" onSubmit={(e) => e.preventDefault()}>
                                        <br />
                                        <p>Usuario: </p> <br />
                                        <input id="user" className="control" type="text" name="user" placeholder="Ingrese su usuario" />
                                        <br />
                                        <p>Contraseña: </p> <br />
                                        <input id="pass" className="control" type="password" name="pass" placeholder="Ingrese su contraseña" />
                                        <br /><br />
                                        <button className="boton" onClick={() => limpiarCadena('user', 'pass')}>Enviar</button>
                                    </form>
                                </section>
                                <h2>NO SE HA LOGEADO</h2>
                            </div>
                        ))
                    }
                </>

                <footer>
                    <p>Universidad del Cauca</p>
                    <br />
                </footer>
            </div>
        </div>
    )
}
