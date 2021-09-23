import React, { useState } from 'react';
import '../../App.css';
import SignupForm from './signup/SignupForm';
import SignupFormSuccess from './signup/SignupFormSuccess';

export default function SignUp() {
    
    const [formIsSubmitted, setFormIsSubmitted] = useState(false);
    
    const submitForm = () => {
        setFormIsSubmitted(true)
    };

    return (
        <>
            <div className='signupPage'>
                {!formIsSubmitted ? <SignupForm submitForm={submitForm}/> : <SignupFormSuccess />}
            </div>
        </>
    );
}
