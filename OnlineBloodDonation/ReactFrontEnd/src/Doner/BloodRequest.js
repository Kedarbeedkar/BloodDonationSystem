import React from "react";
import Form from "react-bootstrap/Form";

export default class DonateBlood extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            uid: 0,
            pname: "",
            bloodgroupid: "",
            quantity: 0.0,
            pcontactno: "",
            paddress: "",
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
                uid: this.state.uid,
                pname: this.state.pname,
                bloodgroupid: this.state.bloodgroupid,
                quantity: this.state.quantity,
                pcontactno: this.state.pcontactno,
                paddress: this.state.paddress,
            }),
        };

        fetch(
            "http://localhost:8080/savebloodrequest?uid=" +
                this.state.uid +
                "&pname=" +
                this.state.pname +
                "&bloodgroupid=" +
                this.state.bloodgroupid +
                "&quantity=" +
                this.state.quantity +
                "&pcontactno=" +
                this.state.pcontactno +
                "&paddress=" +
                this.state.paddress,
            reqData
        )
            .then((resp) => resp.json())
            .then((data) => this.setState({ st: data, success: true }));
        this.props.history.push("/donorhome");
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
                            <h1>Blood Request Form</h1>
                        </div>
                    </div>
                </center>
                <div class="row">
                    <div class="col-sm-12 bg-light">
                        <form onSubmit={this.submitReq}>
                            <div>
                                <h4 style={{ color: "red" }}>User ID {JSON.parse(localStorage.getItem("loggedinuser")).uid.uid}</h4>
                                <div class="row">
                                    <div class="col">
                                        User ID: <input type="number" name="uid" class="form-control" placeholder="Enter User ID mentioned above" onChange={this.handleChange} /> <br />
                                        <br />
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="col">
                                        Patient Name : <input type="text" name="pname" class="form-control" placeholder="Enter Full name" onChange={this.handleChange} /> <br />
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
                                        Quantity: <input type="number" name="quantity" class="form-control" placeholder="Enter quantity" onChange={this.handleChange} /> <br />
                                        <br />
                                    </div>
                                </div>
                            </div>

                            <div>
                                <div class="row">
                                    <div class="col">
                                        Patient Contact : <input type="number" name="pcontactno" class="form-control" placeholder="Enter Contact" onChange={this.handleChange} /> <br />
                                        <br />
                                    </div>
                                </div>
                            </div>
                            <div>
                                <div class="row">
                                    <div class="col">
                                        Patient Address : <input type="text" name="paddress" class="form-control" placeholder="Enter Address" onChange={this.handleChange} /> <br />
                                        <br />
                                    </div>
                                </div>
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
