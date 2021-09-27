import React from "react";
import Form from "react-bootstrap/Form";
export default class BloodRequestStatus extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            requestid: "",
            requeststatus: "",
            blood_request: [],
            display: "none",
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
                requestid: this.state.requestid,
                requeststatus: this.state.requeststatus,
            }),
        };

        fetch("http://localhost:8080/updaterequeststatus?requestid=" + this.state.requestid + "&requeststatus=" + this.state.requeststatus, reqData)
            .then((resp) => resp.json())
            .then((data) => this.setState({ st: data, success: true }));
        this.props.history.push("/login");
    };

    componentDidMount = () => {
        fetch("http://localhost:8080/getallbloodrequest")
            .then((resp) => resp.json())
            .then((data) => {
                this.setState({ blood_request: data });
                console.log(data);
            });
    };

    render() {
        return (
            <div>
                <div>
                    <br />
                    <br />
                    <center>
                        <h1>Blood Request List</h1>
                    </center>
                    <table class="table table-bordered table-success">
                        <thead class="table table-dark">
                            <tr>
                                <th scope="col">REQUESTID</th>
                                <th scope="col">UID</th>
                                <th scope="col">PATIENT NAME</th>
                                <th scope="col">REQUEST DATE</th>
                                <th scope="col">BLOOD GROUP ID</th>
                                <th scope="col">QUANTIT</th>
                                <th scope="col">PATIENT CONTACT NUMBER</th>
                                <th scope="col">PATIENT ADDRESS</th>
                                <th scope="col">REQUEST STATUS</th>
                            </tr>
                        </thead>
                        <tbody>
                            {this.state.blood_request.map((obj) => {
                                return (
                                    <tr>
                                        <td>{obj.requestid}</td>
                                        <td>{obj.uid.uid}</td>
                                        <td>{obj.pname}</td>
                                        <td>{obj.request_date}</td>
                                        <td>{obj.bloodgroupid.bloodgroupid}</td>
                                        <td>{obj.quantity}</td>
                                        <td>{obj.pcontactno}</td>
                                        <td>{obj.paddress}</td>
                                        <td>{obj.requeststatus}</td>
                                    </tr>
                                );
                            })}
                        </tbody>
                    </table>
                </div>
                <form onSubmit={this.submitReq}>
                    <div>
                        <div class="row">
                            <div class="col">
                                Request ID: <input type="number" name="requestid" class="form-control" placeholder="Enter Request ID" onChange={this.handleChange} required /> <br />
                                <br />
                            </div>

                            <div class="col">
                                Request status :
                                <Form.Select aria-label="Floating label select example" name="requeststatus" onChange={this.handleChange}>
                                    <option>select Request status </option>
                                    <option value="Accepted" id="requeststatus">
                                        Accepted
                                    </option>
                                    <option value="Deny" id="requeststatus">
                                        Deny
                                    </option>
                                </Form.Select>
                            </div>
                        </div>
                        <div>
                            <input type="submit" value="Submit" />
                        </div>
                    </div>
                </form>
            </div>
        );
    }
}
