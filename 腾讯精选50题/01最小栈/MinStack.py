#155.×îÐ¡Õ»

class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.arrays = []
        self.min_val = []
        

    def push(self, x: int) -> None:
        self.arrays.append(x)
        if len(self.min_val)==0:
            self.min_val.append(x)
        else:
            if x > self.min_val[-1]:
                x = self.min_val[-1]
            self.min_val.append(x)

    def pop(self) -> None:
        self.min_val.pop()
        self.arrays.pop()
        

    def top(self) -> int:
        return self.arrays[-1] 
        

    def getMin(self) -> int:
        return self.min_val[-1]
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()