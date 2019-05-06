import React, { Component } from 'react'
import './Login.css';
import logo from './images/logo/logov1.png';
import defaultAvatar from './../images/default.png';
import Header from './../Header';
import Footer from './../Footer';
export default class Login extends Component {
  render() {
    return (
        <div>
        <meta charSet="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta httpEquiv="X-UA-Compatible" content="ie=edge" />
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossOrigin="anonymous" />
        <link rel="stylesheet" href="/assets/fonts/flaticons/flaticon.css" />
        <title>صفحه ی ورود</title>
        <Header/>
        <main style={{backgroundColor: "#C1EEF3"}}>
          <div className="loginbox">
            <img src={defaultAvatar} className="avatar" />
            <h1 style={{margin: 0, padding: '0 0 20px', textAlign: 'center', fontSize: '22px'}}>وارد شوید</h1>
            <form action="/Home">
              <p>نام کاربری</p>
              <input type="text" onBlur={(e) => e.target.placeholder = "نام کاربری را وارد کنید"} onFocus={(e) => e.target.placeholder = ""} placeholder="نام کاربری را وارد کنید" />
              <p>رمز عبور</p>
              <input type="password" onBlur={(e) => e.target.placeholder = "رمز عبور را وارد کنید"} onFocus={(e) => e.target.placeholder = ""} placeholder="رمز عبور را وارد کنید" />
              <input type="submit" value="ورود" />
            </form>
          </div>
        </main>
        <Footer/>
      </div>
    )
  }
}
