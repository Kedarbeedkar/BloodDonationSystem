import React from "react";
import { Link, Route } from "react-router-dom";
import Home from "./Home";
import Navbar from "react-bootstrap/Navbar";
import Container from "react-bootstrap/Container";
import Nav from "react-bootstrap/Nav";
import { DonorRegistartion } from "../Doner/DonorRegistration";
import { HospitalRegistartion } from "../Hospital/HospitalRegistartion";
import Login from "./Login";
import { BrowserRouter } from "react-router-dom";
import { DonorHome } from "../Doner/DonorHome";
import BloodBankHome from "../BloodBank/BloodBankHome";
import HospitalHome from "../Hospital/HospitalHome";
import DonateBlood from "../Doner/DonateBlood";
import ForgotPassword from "./ForgotPassword";
import mystore from "../Reducer/mystore";
import { Switch } from "react-router";

export default class MainMenu extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            flag: false,
        };
    }

    render() {
        mystore.subscribe(() => {
            this.setState({ flag: mystore.getState().loggedin });
        });
        return (
            <BrowserRouter>
                <div style={{ display: this.state.flag ? "none" : "block" }}>
                    <div class="topnav" id="mytopnav">
                        <Navbar bg="dark" variant="dark">
                            <Container>
                                <Navbar.Brand href="#home">Menu</Navbar.Brand>
                                <Nav className="me-auto">
                                    <Nav.Link href="/" style={{ marginLeft: "60px" }} class="text-decoration-none text-white">
                                        Home
                                    </Nav.Link>
                                    <Nav.Link href="DonorRegistartion" style={{ marginLeft: "60px" }} class="text-decoration-none text-white">
                                        Donor Registration
                                    </Nav.Link>
                                    <Nav.Link href="HospitalRegistartion" style={{ marginLeft: "60px" }} class="text-decoration-none text-white">
                                        Hospital Registration
                                    </Nav.Link>

                                    <Nav.Link href="Login" style={{ marginLeft: "60px" }} class="text-decoration-none text-white">
                                        Login
                                    </Nav.Link>
                                    <Nav.Link href="ForgotPassword" style={{ marginLeft: "60px" }}>
                                        Forgot Password
                                    </Nav.Link>
                                </Nav>
                            </Container>
                        </Navbar>
                    </div>
                    <div></div>
                    <Route path="/" component={Home} exact />
                    <Route path="/DonorRegistartion" component={DonorRegistartion} />
                    <Route path="/HospitalRegistartion" component={HospitalRegistartion} />
                    <Route path="/Login" component={Login} />
                    <Route path="/ForgotPassword" component={ForgotPassword} />
                </div>
                <Switch>
                    <Route path="/bloodbankhome" component={BloodBankHome} />
                    <Route path="/donorhome" component={DonorHome} />
                    <Route path="/hospitalhome" component={HospitalHome} />

                    <Route path="/DonateBlood" component={DonateBlood} exact />
                    <Route path="/" component={Home} exact />
                </Switch>
            </BrowserRouter>
        );
    }
}
