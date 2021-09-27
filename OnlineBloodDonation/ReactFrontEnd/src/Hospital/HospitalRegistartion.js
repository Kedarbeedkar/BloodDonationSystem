import React from "react";
import Form from "react-bootstrap/Form";
export class HospitalRegistartion extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            emailid: "",
            password: "",
            squestionid: "",
            answer: "",
            name: "",
            address: "",
            city: "",
            contactno: "",
            st: {},
            success: false,
        };
    }

    handleChange = (e) => {
        let nm = e.target.name;
        let val = e.target.value;
        this.setState({ [nm]: val });
    };

    submitReq = (e) => {
        e.preventDefault();
        //console.log(this.state);
        const reqData = {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({
                emailid: this.state.emailid,
                password: this.state.password,
                squestionid: this.state.squestionid,
                answer: this.state.answer,
                name: this.state.name,
                address: this.state.address,
                city: this.state.city,
                contactno: this.state.contactno,
            }),
        };

        fetch("http://localhost:8080/hospitalregistartion", reqData)
            .then((resp) => resp.json())
            .then((data) => this.setState({ st: data, success: true }));
        this.props.history.push("/login");
    };

    render() {
        return (
            <div>
                <center>
                    <div>
                        <h1>Lifestream Blood Bank</h1>
                    </div>
                    <div class="row">
                        <div class="col-sm-12 text-white" style={{ backgroundColor: "black" }}>
                            <br />
                            <h1> Hospital Registration Form</h1>
                        </div>
                    </div>
                </center>
                <div class="row">
                    <div class="col-sm-12 bg-light">
                        <form onSubmit={this.submitReq}>
                            <div>
                                <div class="row">
                                    <div class="col">
                                        <br />
                                        EmailID : <input type="text" name="emailid" class="form-control" placeholder="Enter Email ID" onChange={this.handleChange} required /> <br />
                                        <br />
                                    </div>
                                </div>
                            </div>
                            <div>
                                <div class="row">
                                    <div class="col">
                                        Password : <input type="password" name="password" class="form-control" placeholder="Enter Password" onChange={this.handleChange} required /> <br />
                                        <br />
                                    </div>
                                </div>
                            </div>
                            <div>
                                <label for="squestionid">Security Question : </label>
                                <Form.Select aria-label="Floating label select example" name="squestionid" onChange={this.handleChange} required>
                                    <option>select Question </option>
                                    <option value="1" id="squestionid">
                                        {" "}
                                        What is your country name?
                                    </option>
                                    <option value="2" id="squestionid">
                                        Which was your favorite subject ?
                                    </option>
                                    <option value="3" id="squestionid">
                                        which is your favorite book?
                                    </option>
                                </Form.Select>
                            </div>
                            <div>
                                <div class="row">
                                    <div class="col">
                                        Answer : <input type="text" name="answer" class="form-control" placeholder="Enter Answer" onChange={this.handleChange} required /> <br /> <br />
                                    </div>
                                </div>
                            </div>

                            <div>
                                <div class="row">
                                    <div class="col">
                                        Name : <input type="text" name="name" class="form-control" placeholder="Enter Full name" onChange={this.handleChange} required /> <br />
                                        <br />
                                    </div>
                                </div>
                            </div>

                            <div>
                                <div class="row">
                                    <div class="col">
                                        Address : <input type="text" name="address" class="form-control" placeholder="Enter Address" onChange={this.handleChange} required /> <br />
                                        <br />
                                    </div>
                                </div>
                            </div>
                            <div>
                                <div class="row">
                                    <div class="col">
                                        City : <input type="text" name="city" class="form-control" placeholder="Enter City" onChange={this.handleChange} required /> <br />
                                        <br />
                                    </div>
                                </div>
                            </div>
                            <div class="col">
                                Contact : <input type="number" name="contactno" class="form-control" placeholder="Enter Contact" onChange={this.handleChange} required /> <br />
                                <br />
                            </div>
                            <div>
                                <input type="submit" value="Submit" />
                            </div>
                        </form>
                        <br />
                        <br />
                    </div>
                </div>
            </div>
        );
    }
}
