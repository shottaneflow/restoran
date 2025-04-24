package org.example.kursovaya.dto;

import java.util.Collection;

public class AuthRequest {
    private String token;
    private Collection<?> roles;

    public AuthRequest() {
    }

    public String getToken() {
        return this.token;
    }

    public Collection<?> getRoles() {
        return this.roles;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setRoles(Collection<?> roles) {
        this.roles = roles;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof AuthRequest)) return false;
        final AuthRequest other = (AuthRequest) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$token = this.getToken();
        final Object other$token = other.getToken();
        if (this$token == null ? other$token != null : !this$token.equals(other$token)) return false;
        final Object this$roles = this.getRoles();
        final Object other$roles = other.getRoles();
        if (this$roles == null ? other$roles != null : !this$roles.equals(other$roles)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof AuthRequest;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $token = this.getToken();
        result = result * PRIME + ($token == null ? 43 : $token.hashCode());
        final Object $roles = this.getRoles();
        result = result * PRIME + ($roles == null ? 43 : $roles.hashCode());
        return result;
    }

    public String toString() {
        return "AuthRequest(token=" + this.getToken() + ", roles=" + this.getRoles() + ")";
    }
}
