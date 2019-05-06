import React, { Component } from 'react';
import axios from 'axios';
export default class ProfileSkillItem extends React.Component<Props, State>{
    profileSkillDelete: (event: React.MouseEvent<HTMLSpanElement, MouseEvent>) => void = (event) => {

       
        var self = this;
        axios.delete("http://localhost:8080/deleteSkill",{
            params:{
                userSkill: self.props.skillName
            }
        })
        .then(function(resp){
            if(resp.status == 200)
                self.setState({isDeletedNow: true});
            
        });
    };
    
    constructor(props: Props){
        super(props);
        this.state = {isDeletedNow: this.props.isDeletedNow, skillRate: this.props.skillRate};
    }
    render(){
        var endorsedClassName: string = "skill-item";
        var spanHover : any = "";

        
        spanHover = <span className="remove-skill">-</span>;
        
        if(this.state.isDeletedNow === false){
            return (
                <li className={endorsedClassName}>
                <span className="skill-name">{this.props.skillName}</span>
                <span className="skill-rating" onClick={this.profileSkillDelete}>
                    <span>{this.state.skillRate}</span>
                    {spanHover}
                </span>
                </li>
            );
        }else{
            return(
                <div></div>
            );
        }
    }
}
interface Props{
    skillName: string;
    skillRate: number;
    isDeletedNow: boolean;
}
interface State{
    isDeletedNow: boolean;
    skillRate : number;
}