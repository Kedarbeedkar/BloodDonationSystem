import React from "react";
import blood from "../Images/3.jpg";
export default class Home extends React.Component {
    //constructor(Props){
    // super(props)

    // }

    render() {
        return (
            <div>
                <div style={{ textAlign: "center" }}>
                    <img src={blood} alt="this is blooddonation image" />
                </div>
                <div class="container">
                    <div class="panel-heading center">
                        <h2 style={{ textAlign: "center" }}>Benefits</h2>
                    </div>
                    <div class="panel-body justify">
                        <li>Donating Blood may reduce the risk of heart disease for men and stimulate the generation of red blood cells.</li>
                        <li> The amount of toxic chemical (eg.mercury,pesticidees,fire retardants) circulating in the blood stream is reduced by the amount cantained in given blood.</li>
                        <li>The good news is you can give blood again and again to help save more lives !</li>
                        <li> if you're a regular blood doner , you can give blood once in 12 weeks</li>
                    </div>
                    <br />
                    <br />
                    <div class="panel-heading center">
                        <h2 style={{ textAlign: "center" }}>World Blood Donors Day</h2>
                    </div>
                    <div class="panel-body justify">
                        Following the success of the World Health Day 2000 with the theme 'Blood Saves Lives', 14th June is observed as the World Blood Donors Day. The date coincides with the birth date of Karl Landsteiner, who discovered
                        the ABO blood group system.
                    </div>
                    <br />
                    <br />
                    <div class="panel-body justify">
                        Every 2 Seconds, someone in the country is in need of blood
                        <br />
                        <br />
                        Every year our nation requires about 4 Crore units of blood
                        <br />
                        <br />
                        Out of which only a meager 5 Lakh units of blood are available
                        <br />
                        <br />
                    </div>
                </div>
            </div>
        );
    }
}
