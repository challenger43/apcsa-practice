let value = 45;
let ogValue = value
let binary = [];
while (value >= 1){
    binary.push(value%2);
    value = Math.floor(value/2);
   
}
binary = binary.reverse().join("")
console.log(binary + " is the binary form of " + ogValue)
