import React, { useState } from 'react';
import '../../App.css';
import LoginForm from './signup/LoginForm';
import LoginFormSuccess from './signup/LoginFormSuccess';


export default function Login() {

    const [formIsSubmitted, setFormIsSubmitted] = useState(false);
    
    const submitForm = () => {
        setFormIsSubmitted(true)
    };

    return (
        <>
            <div className='signupPage'>
            {!formIsSubmitted ? <LoginForm submitForm={submitForm}/> : <LoginFormSuccess />}
            </div>
        </>
    );
}
