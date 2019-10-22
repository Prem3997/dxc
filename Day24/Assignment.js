import React, { Component } from 'react';
import './Assignment.css'

class Assignment extends Component {
    constructor(props){
        super(props);
        this.state={
          title: 'Company PortFolio',
          act: 0,
          index: '',
          datas: []
        }
      } 
    
      componentDidMount(){
        this.refs.companyName.focus();
      }
    
      addCompany = (e) =>{
        e.preventDefault();
        console.log('try');
    
        let datas = this.state.datas;
        let companyName = this.refs.companyName.value;
        let companyDescription = this.refs.companyDescription.value;
    
        if(this.state.act === 0){  
          let data = {
            companyName, companyDescription
          }
          datas.push(data);
        }else{                     
          let index = this.state.index;
          datas[index].companyName = companyName;
          datas[index].companyDescription = companyDescription;
        }    
    
        this.setState({
          datas: datas,
          act: 0
        });
    
        this.refs.myForm.reset();
        this.refs.companyName.focus();
      }
    
      removeCompany = (i) => {
        let datas = this.state.datas;
        datas.splice(i,1);
        this.setState({
          datas: datas
        });
    
        this.refs.myForm.reset();
        this.refs.companyName.focus();
      }
    
      editCompany = (i) => {
        let data = this.state.datas[i];
        this.refs.companyName.value = data.companyName;
        this.refs.companyDescription.value = data.companyDescription;
    
        this.setState({
          act: 1,
          index: i
        });
    
        this.refs.companyName.focus();
      }  
    
      render() {
        let datas = this.state.datas;
        return (
          <div className="App">
            <h2>{this.state.title}</h2>
            <form ref="myForm" className="myForm">
              <input type="text" ref="companyName" placeholder="Your Company Name" className="formField" />
              <input type="text" ref="companyDescription" placeholder="Your Company Description" className="formField" />
              <button onClick={(e)=>this.addCompany(e)} className="myButton">submit </button>
            </form>
            <pre>
              {datas.map((data, i) =>
                <li key={i} className="myList">
                  {i+1}. {data.companyName}, {data.companyDescription}
                  <button onClick={()=>this.removeCompany(i)} className="myListButton">remove </button>
                  <button onClick={()=>this.editCompany(i)} className="myListButton">edit </button>
                </li>
              )}
            </pre>
          </div>
        );
      }
    }    
export default Assignment;