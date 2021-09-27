import React from "react";
import mystore from "../Reducer/mystore";
import { Link, Route, Switch } from "react-router-dom";
import Navbar from "react-bootstrap/Navbar";
import Container from "react-bootstrap/Container";
import Nav from "react-bootstrap/Nav";
import { BrowserRouter } from "react-router-dom";
import DonateBlood from "./DonateBlood";
import BloodRequest from "./BloodRequest";
import Donor from "../Images/Donor.jpg";
export class DonorHome extends React.Component {
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
                <BrowserRouter>
                    <div>
                        <center>
                            <div class="topnav" id="mytopnav">
                                <Navbar bg="dark" variant="dark">
                                    <Container>
                                        <Navbar.Brand>Donor Menu</Navbar.Brand>
                                        <Nav className="me-auto" style={{ marginLeft: "60px" }}>
                                            <Nav.Link href="DonorHome">Home</Nav.Link>
                                            <Nav.Link>
                                                <Link to="/DonateBlood" style={{ marginLeft: "60px" }} class="text-decoration-none text-white">
                                                    Donate Blood
                                                </Link>
                                            </Nav.Link>
                                            <Nav.Link>
                                                <Link to="/BloodRequest" style={{ marginLeft: "60px" }} class="text-decoration-none text-white">
                                                    Blood Request
                                                </Link>
                                            </Nav.Link>
                                            <Nav.Link style={{ marginLeft: "60px" }} href="/" onclick={this.logout}>
                                                Logout
                                            </Nav.Link>
                                        </Nav>
                                    </Container>
                                </Navbar>
                            </div>
                            <div>
                                <Switch>
                                    <Route path="/BloodRequest" component={BloodRequest} />
                                    <Route path="/DonateBlood" component={DonateBlood} exact />
                                </Switch>
                            </div>
                        </center>
                    </div>
                </BrowserRouter>

                <div style={{ textAlign: "center" }}>
                    <img src={Donor} alt="this is blooddonation image" />
                </div>
            </div>
        );
    }
}
