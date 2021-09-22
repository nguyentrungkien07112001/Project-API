import React from 'react';

function Target(props) {
    return (
        <>
           <div className='target__container'>
                    <img className="target__img" alt='Random' src={props.src}/>
                    <div className="target__right__column">
                    <h1 className="target__title">{props.title}</h1>
                        <p className="target__status">Trạng thái: <span className="target__status__color">{props.status}</span></p>
                    <div className="target__detail">
                        
                        <p className="target__creator">Người tạo: {props.creator}</p>
                        <p className="target__progress">Tiến độ: {props.progress}%</p>
                    </div>
                    </div>
                </div> 
        </>
    );
}

export default Target;
