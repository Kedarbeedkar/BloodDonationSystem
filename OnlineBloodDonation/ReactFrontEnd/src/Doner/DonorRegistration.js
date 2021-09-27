import React from "react";
import Form from "react-bootstrap/Form";
export class DonorRegistartion extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            emailid: "",
            password: "",
            squestionid: 0,
            answer: "",
            name: "",
            gender: "",
            dob: "",
            bloodgroupid: "",
            contactno: "",
            emailid: "",
            address: "",
            city: "",
            st: {},
            success: false,
        };
    }

    handleChange = (e) => {
        let nm = e.target.name;
        let val = e.target.value;
        //alert(nm+":"+val)
        this.setState({ [nm]: val });
    };

    submitReq = (e) => {
        console.log(this.state);
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
                gender: this.state.gender,
                dob: this.state.dob,
                bloodgroupid: this.state.bloodgroupid,
                contactno: this.state.contactno,
                address: this.state.address,
                city: this.state.city,
            }),
        };

        fetch("http://localhost:8080/donerregistartion", reqData)
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
                            <h1>Donor Registration Form</h1>
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
                                        EmailID : <input type="text" name="emailid" class="form-control" placeholder="Enter Email ID" onChange={this.handleChange} /> <br />
                                        <br />
                                    </div>
                                </div>
                            </div>
                            <div>
                                <div class="row">
                                    <div class="col">
                                        Password : <input type="password" name="password" class="form-control" placeholder="Enter Password" onChange={this.handleChange} /> <br />
                                        <br />
                                    </div>
                                </div>
                            </div>
                            <div>
                                <label for="squestionid">Security Question : </label>
                                <Form.Select aria-label="Floating label select example" name="squestionid" onChange={this.handleChange}>
                                    <option>select Question </option>
                                    <option value="1" id="squestionid">
                                        {" "}
                                        What is your country name?
                                    </option>
                                    <option value="2" id="squestionid">
                                        what was your favorite subject ?
                                    </option>
                                    <option value="3" id="squestionid">
                                        what is your favorite book?
                                    </option>
                                </Form.Select>
                            </div>
                            <div>
                                <div class="row">
                                    <div class="col">
                                        Answer : <input type="text" name="answer" class="form-control" placeholder="Enter Answer" onChange={this.handleChange} /> <br /> <br />
                                    </div>
                                </div>
                            </div>
                            <div>
                                <div class="row">
                                    <div class="col">
                                        Name : <input type="text" name="name" class="form-control" placeholder="Enter Full name" onChange={this.handleChange} /> <br />
                                        <br />
                                    </div>
                                </div>
                            </div>
                            <div>
                                <div class="row">
                                    <div class="col">
                                        <label for="gender">Gender :&nbsp;&nbsp;</label>
                                        Male
                                        <input type="radio" name="gender" value="M" onChange={this.handleChange} />
                                        Female
                                        <input type="radio" name="gender" value="F" onChange={this.handleChange} />
                                        <br />
                                    </div>
                                </div>
                            </div>
                            <div>
                                <div class="row">
                                    <div class="col">
                                        DOB : <input type="date" name="dob" onChange={this.handleChange} /> <br />
                                        <br />
                                    </div>
                                </div>
                            </div>
                            <div>
                                <div class="row">
                                    <div class="col">
                                        Blood Group ID :
                                        <Form.Select aria-label="Floating label select example" name="bloodgroupid" onChange={this.handleChange}>
                                            <option>select Blood Group ID </option>
                                            <option value="1" id="bloodgroupid">
                                                A+
                                            </option>
                                            <option value="2" id="bloodgroupid">
                                                A-
                                            </option>
                                            <option value="3" id="bloodgroupid">
                                                AB+
                                            </option>
                                            <option value="4" id="bloodgroupid">
                                                AB-
                                            </option>
                                            <option value="5" id="bloodgroupid">
                                                B+
                                            </option>
                                            <option value="6" id="bloodgroupid">
                                                B-
                                            </option>
                                            <option value="7" id="bloodgroupid">
                                                O+
                                            </option>
                                            <option value="8" id="bloodgroupid">
                                                O-
                                            </option>
                                        </Form.Select>
                                        <br />
                                        <br />
                                    </div>
                                </div>
                            </div>
                            <div>
                                <div class="row">
                                    <div class="col">
                                        Contact : <input type="number" name="contactno" class="form-control" placeholder="Enter Contact" onChange={this.handleChange} /> <br />
                                        <br />
                                    </div>
                                </div>
                            </div>
                            <div>
                                <div class="row">
                                    <div class="col">
                                        Address : <input type="text" name="address" class="form-control" placeholder="Enter Address" onChange={this.handleChange} /> <br />
                                        <br />
                                    </div>
                                </div>
                            </div>
                            <div>
                                <div class="row">
                                    <div class="col">
                                        City : <input type="text" name="city" class="form-control" placeholder="Enter City" onChange={this.handleChange} /> <br />
                                        <br />
                                    </div>
                                </div>
                            </div>
                            <div>
                                <input type="submit" value="Submit" />
                            </div>
                            <p style={{ display: this.state.success ? "block" : "none" }}> Doner with id as {this.state.st.uid} is saved successfully</p>
                        </form>
                        <br />
                        <br />
                    </div>
                </div>
            </div>
        );
    }
}
