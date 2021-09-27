import React from "react";
import mystore from "../Reducer/mystore";
import { BrowserRouter, Link, Route, Switch } from "react-router-dom";
import Navbar from "react-bootstrap/Navbar";
import Container from "react-bootstrap/Container";
import BloodRequestHospital from "./BloodRequestHospital";
import Nav from "react-bootstrap/Nav";
import Hospital from "../Images/Hospital.jpg";
export default class HospitalHome extends React.Component {
    constructor(props) {
        super(props);
    }
    logout = () => {
        mystore.dispatch({ type: "LOGGEDOUT" });
        localStorage.removeItem("loggedinuser");
        this.props.history.push("/");
    };

    render() {
        return (
            <div>
                <div>
                    <h1>Welcome {JSON.parse(localStorage.getItem("loggedinuser")).name}</h1>
                </div>
                <div class="topnav" id="mytopnav">
                    <BrowserRouter>
                        <div>
                            <div>
                                <Navbar bg="dark" variant="dark">
                                    <Container>
                                        <Navbar.Brand>Hospital Menu</Navbar.Brand>
                                        <Nav className="me-auto">
                                            <Nav.Link>
                                                <Link to="/BloodRequestHospital" style={{ marginLeft: "60px" }} class="text-decoration-none text-white">
                                                    Blood Request
                                                </Link>
                                            </Nav.Link>
                                            <Nav.Link href="/" onclick={this.logout} style={{ marginLeft: "60px" }} class="text-decoration-none text-white">
                                                Logout
                                            </Nav.Link>
                                        </Nav>
                                    </Container>
                                </Navbar>
                            </div>
                            <div>
                                <Switch>
                                    <Route path="/BloodRequestHospital" component={BloodRequestHospital} />
                                </Switch>
                            </div>
                        </div>
                    </BrowserRouter>
                </div>
                <div style={{ textAlign: "center" }}>
                    <img src={Hospital} alt="this is blooddonation image" />
                </div>
            </div>
        );
    }
}
